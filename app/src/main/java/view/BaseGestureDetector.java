package view;

/**
 * Created by Yao on 2015/10/23.
 */

import android.content.Context;
import android.view.MotionEvent;

/**
 * 手势识别基类
 */
public abstract class BaseGestureDetector {
    /**
     * start flag
     */
    protected boolean mGestureInProgress;

    protected MotionEvent mPreMotionEvent;

    protected MotionEvent mCurrentMotionEvent;

    protected  Context mContext;

    public BaseGestureDetector(Context context){
        mContext = context;
    }

    public boolean onTouchEvent(MotionEvent event){
        if (!mGestureInProgress){
            handleStartProgressEvent(event);
        }else {
            handleInProgressEvent(event);
        }
        return true;
    }

    protected abstract void handleInProgressEvent(MotionEvent event);

    protected abstract void handleStartProgressEvent(MotionEvent event);

    protected abstract void updateStateByEvent(MotionEvent event);


    /**
     * recycle
     */
    protected void resetState()
    {
        if (mPreMotionEvent != null)
        {
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }
        if (mCurrentMotionEvent != null)
        {
            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent = null;
        }
        mGestureInProgress = false;
    }
}
