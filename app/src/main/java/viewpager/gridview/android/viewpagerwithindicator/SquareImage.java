package viewpager.gridview.android.viewpagerwithindicator;

import android.content.Context;
import android.util.AttributeSet;



public class SquareImage extends android.support.v7.widget.AppCompatImageView {

    public SquareImage(final Context context) {
        super(context);
    }

    public SquareImage(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImage(final Context context, final AttributeSet attrs,
                       final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        } else {
            setMeasuredDimension(measuredWidth, measuredWidth);

        }

    }

}
