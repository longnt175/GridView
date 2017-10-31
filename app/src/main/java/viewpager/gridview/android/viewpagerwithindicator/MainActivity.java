package viewpager.gridview.android.viewpagerwithindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public PageIndicator mIndicator;
    List<Event> eventList;
    private MyViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager = (MyViewPager) findViewById(R.id.pager);
        mIndicator = (PageIndicator) findViewById(R.id.pagerIndicator);
        eventList = new ArrayList<>();
        eventList.add(new Event("1", "Fire", "", ""));
        eventList.add(new Event("2", "Nghia", "", ""));
        eventList.add(new Event("3", "Praneeth", "", ""));
        eventList.add(new Event("4", "Civil Unrest", "", ""));
        eventList.add(new Event("5", "Explosion", "", ""));
        eventList.add(new Event("6", "Bomb", "", ""));
        eventList.add(new Event("7", "Personal Threat", "", ""));
        eventList.add(new Event("8", "Chemical Spill", "", ""));
        eventList.add(new Event("9", "Other", "", ""));
        eventList.add(new Event("10", "Flood", "", ""));
        myViewPager.setData(eventList, this, 2, 2);

        mIndicator.setViewPager(myViewPager);
    }


}
