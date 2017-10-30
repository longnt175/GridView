package viewpager.gridview.android.viewpagerwithindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainActivity extends FragmentActivity {

    public PageIndicator mIndicator;
    ArrayList<Category> codeCategory;
    String deviceNames[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z"};
    private ViewPager awesomePager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomePager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (PageIndicator) findViewById(R.id.pagerIndicator);

        ArrayList<String> arrayList = new ArrayList<>();

        Category category = new Category();

        for (int i = 0; i < deviceNames.length; i++) {
            arrayList.add(i, deviceNames[i]);
            category.name = arrayList.get(i);
        }

        codeCategory = new ArrayList<>();
        codeCategory.add(category);

        Iterator<String> it = arrayList.iterator();

        List<GridFragment> gridFragments = new ArrayList<>();

        int i = 0;
        while (it.hasNext()) {
            ArrayList<GridItem> gridItemList = new ArrayList<>();

            GridItem itm = new GridItem(0, it.next());
            gridItemList.add(itm);
            i = i + 1;

            if (it.hasNext()) {
                GridItem itm1 = new GridItem(1, it.next());
                gridItemList.add(itm1);
                i = i + 1;
            }

            if (it.hasNext()) {
                GridItem itm2 = new GridItem(2, it.next());
                gridItemList.add(itm2);
                i = i + 1;
            }

            if (it.hasNext()) {
                GridItem itm3 = new GridItem(3, it.next());
                gridItemList.add(itm3);
                i = i + 1;
            }

//            if (it.hasNext()) {
//                GridItem itm4 = new GridItem(4, it.next());
//                gridItemList.add(itm4);
//                i = i + 1;
//            }
//
//            if (it.hasNext()) {
//                GridItem itm5 = new GridItem(5, it.next());
//                gridItemList.add(itm5);
//                i = i + 1;
//            }
//
//            if (it.hasNext()) {
//                GridItem itm6 = new GridItem(6, it.next());
//                gridItemList.add(itm6);
//                i = i + 1;
//            }
//
//            if (it.hasNext()) {
//                GridItem itm7 = new GridItem(7, it.next());
//                gridItemList.add(itm7);
//                i = i + 1;
//            }
//
//            if (it.hasNext()) {
//                GridItem itm8 = new GridItem(8, it.next());
//                gridItemList.add(itm8);
//                i = i + 1;
//            }

            GridItem[] gp = {};
            GridItem[] gridPage = gridItemList.toArray(gp);
            gridFragments.add(new GridFragment(gridPage, MainActivity.this));
        }

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), gridFragments);
        awesomePager.setAdapter(pagerAdapter);
        mIndicator.setViewPager(awesomePager);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {

        private List<GridFragment> fragments;

        public PagerAdapter(FragmentManager fm, List<GridFragment> fragments) {
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
