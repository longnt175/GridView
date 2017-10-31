package viewpager.gridview.android.viewpagerwithindicator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

public class PageFragment extends Fragment{
	
	private GridView mGridView;
	private GridAdapter mGridAdapter;
	List<Event> events;
	private Activity activity;

	public PageFragment(List<Event> events, Activity activity) {
		this.events = events;
		this.activity = activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view;
		
		view = inflater.inflate(R.layout.fragment_pager, container, false);
		
		mGridView = (GridView) view.findViewById(R.id.grid_view);
		
		return view;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		if(activity != null) {

			mGridAdapter = new GridAdapter(activity, events);
			
			if(mGridView != null){
				mGridView.setAdapter(mGridAdapter);
			}
			
			mGridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int pos, long id) {
					
					onGridItemClick((GridView) parent, view, pos, id);
				}
			});
		}
	}
	
	public void onGridItemClick(GridView g, View v, int pos, long id) {
		Toast.makeText(
				activity,
				"Position Clicked: " + pos + " & Text is: "
						+ events.get(pos).getIncidentName(), Toast.LENGTH_LONG).show();
	}
}
