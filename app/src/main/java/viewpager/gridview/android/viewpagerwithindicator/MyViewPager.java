package viewpager.gridview.android.viewpagerwithindicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyViewPager extends ViewPager {
    int numberOfRows = 4;
    int numberOfColumns = 4;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(List<Event> data, FragmentActivity activity, int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        Iterator<Event> it = data.iterator();
        List<PageFragment> pageFragments = new ArrayList<>();
        while (it.hasNext()) {
            ArrayList<Event> eventList = new ArrayList<>();
            for (int i = 0; i < numberOfRows * numberOfColumns; i++) {
                if (it.hasNext()) {
                    eventList.add(it.next());
                }
            }
            pageFragments.add(new PageFragment(eventList, activity));
        }
        PagerAdapter pagerAdapter = new PagerAdapter(activity.getSupportFragmentManager(), pageFragments);
        setAdapter(pagerAdapter);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight() + child.getPaddingTop() + getPaddingBottom();
            if (h > height) height = h;
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height * numberOfRows + numberOfRows * 10, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        private List<PageFragment> fragments;

        public PagerAdapter(FragmentManager fm, List<PageFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int pos) {
            return this.fragments.get(pos);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}

