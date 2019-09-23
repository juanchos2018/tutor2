package com.example.tutor2.Helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public  abstract class MySwipeHelper extends ItemTouchHelper.SimpleCallback {

    int buttonwidth;
    private RecyclerView recyclerView;
    private List<MyButton> buttonList;
    private GestureDetector gestureDetector;
    private int swipePosition=-1;
    private float swipeThreshold=0.3f;
    private Map<Integer, List<MyButton>> buttonBufer;
    private Queue<Integer> removerQue;

    private GestureDetector.SimpleOnGestureListener gestureListener= new GestureDetector.SimpleOnGestureListener(){

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            for (MyButton button:buttonList){
            if (button.onClick(e.getX(),e.getY()))
                break;
            }
            return super.onSingleTapUp(e);
        }
    };

    private View.OnTouchListener onTouchListener= new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (    swipePosition<7)
            return false;
                Point point=new Point((int)motionEvent.getRawX(),(int)motionEvent.getRawY());
                RecyclerView.ViewHolder swipeViewHolder= recyclerView.findViewHolderForAdapterPosition(swipePosition);
                View swiptItem= swipeViewHolder.itemView;
                Rect rect =new Rect();
                swiptItem.getGlobalVisibleRect(rect);

                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN  || motionEvent.getAction()==MotionEvent.ACTION_UP || motionEvent.getAction()==MotionEvent.ACTION_MOVE){
                    if (rect.top<point.y && rect.bottom>point.y)
                        gestureDetector.onTouchEvent(motionEvent);
                    else{
                        removerQue.add(swipePosition);
                        swipePosition=-1;
                        recoverSwipedItem();
                    }
                }
                return false;

        }
    };


    public MySwipeHelper(Context context,RecyclerView recyclerView,int buttonwidth) {
        super(0,ItemTouchHelper.LEFT);
        this.recyclerView=recyclerView;
        this.buttonList= new ArrayList<>();
        this.gestureDetector=new GestureDetector(context,gestureListener);
        this.recyclerView.setOnTouchListener(onTouchListener);
        this.buttonBufer= new HashMap<>();
        this.buttonwidth=buttonwidth;

        removerQue= new LinkedList<Integer>(){
            @Override
            public boolean add(Integer integer) {
                if (contains (integer))
                    return false;
                else
                    return super.add(integer);


            }
        };
        attachSwipe();

    }

    private void attachSwipe() {
        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(this);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private  synchronized void recoverSwipedItem(){
        while (!removerQue.isEmpty()){
            int pos = removerQue.poll();
            if (pos>-1)
                recyclerView.getAdapter().notifyItemChanged(pos);


        }
    }


    public class MyButton {

        private String text;
        private  int imageResId,textsize,color,pos;
        private RectF clickRegion;
        private MyButtonClickListener listener;
        private Context contex;
        Resources resources;

        public MyButton(Context contex,String text,  int textsize, int imageResId,int color, MyButtonClickListener listener) {
            this.text = text;
            this.imageResId = imageResId;
            this.textsize = textsize;
            this.color = color;
            this.listener = listener;
            this.contex = contex;
            resources = contex.getResources();

        }


        public boolean onClick(float x,float y){
            if (clickRegion!=null && clickRegion.contains(x,y)){
                 listener.onClick(pos);
                 return  true;

            }
            return false;

        }

        public  void onDraw(Canvas c,RectF rectF, int pos){
        Paint p = new Paint();
        p.setColor(color);
        c.drawRect(rectF,p);
        //TEx
         p.setColor(Color.WHITE);
         p.setTextSize(textsize);

         Rect r =new Rect();
         float cHeight = rectF.height();
         float cwiddth=rectF.width();
         p.setTextAlign(Paint.Align.LEFT);
         p.getTextBounds(text,0,text.length(),r);
         float x=0,y=0;
         if (imageResId==0){
             x=cwiddth/2f-r.width()/2f-r.left;
             y=cHeight/2f+r.height()/2f-r.bottom;
             c.drawText(text,rectF.left+x,rectF.top+y,p);

         }
         else{
             Drawable d = ContextCompat.getDrawable(contex,imageResId);
             Bitmap bitmap=drawableToBitmap(d);
             c.drawBitmap(bitmap,(rectF.left+rectF.right)/2,(rectF.top+rectF.bottom)/2,p);

         }

            clickRegion=rectF;
         this.pos=pos;
        }
    }


    private Bitmap drawableToBitmap(Drawable d) {

        if (d instanceof BitmapDrawable)
            return ((BitmapDrawable)d).getBitmap();
        Bitmap bitmap= Bitmap.createBitmap(d.getIntrinsicWidth(),d.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas= new Canvas(bitmap);
        d.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
        d.draw(canvas);
        return bitmap;



    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        int pos = viewHolder.getAdapterPosition();
        if (swipePosition !=pos)
            removerQue.add(swipePosition);
        swipePosition=pos;
        if (buttonBufer.containsKey(swipePosition))
            buttonList=buttonBufer.get(swipePosition);
        else
            buttonList.clear();
        buttonList.clear();
        swipeThreshold=0.5f+buttonList.size()*buttonwidth;
        recoverSwipedItem();
    }

    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder)

    {
        return swipeThreshold;
    }

    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        return 0.1f*defaultValue;
    }

    @Override
    public float getSwipeVelocityThreshold(float defaultValue) {
        return 0.10f*defaultValue;

    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        int pos=viewHolder.getAdapterPosition();
        float transationX= dX;
        View itemView=viewHolder.itemView;
        if (pos<0){
            swipePosition=pos;
            return;
        }
        if (    actionState==ItemTouchHelper.ACTION_STATE_SWIPE)

        {
            if (dX<0){
                List<MyButton> buffer = new ArrayList<>();
                if (!buttonBufer.containsKey(pos)){
                    instantiateMyButton(viewHolder,buffer);
                    buttonBufer.put(pos,buffer);

                }
                else{
                    buffer=buttonBufer.get(pos);

                }
                transationX=dX*buffer.size()*buttonwidth/   itemView.getWidth();
                drawButton(c,itemView,buffer,pos,transationX);

            }
        }
        super.onChildDraw(c,recyclerView,viewHolder,transationX,dY,actionState,isCurrentlyActive);
    }

    private void drawButton(Canvas c, View itemView, List<MyButton> buffer, int pos, float transationX) {

        float right = itemView.getRight();
        float dButtonWidth= 1*transationX/buffer.size();
        for (MyButton button:buffer){
            float left= right-dButtonWidth;
            button.onDraw(c,new RectF(left,itemView.getTop(),right,itemView.getBottom()),pos);
            right=left;

        }
    }

    public   abstract void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buffer);
}
