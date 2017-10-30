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

public class GridFragment extends Fragment{
	
	private GridView mGridView;
	private GridAdapter mGridAdapter;
	GridItem[] gridItems = {};
	private Activity activity;
	
	public GridFragment(GridItem[] gridItems, Activity activity) {
		this.gridItems = gridItems;
		this.activity = activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view;
		
		view = inflater.inflate(R.layout.grid, container, false);
		
		mGridView = (GridView) view.findViewById(R.id.grid_view);
		
		return view;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		if(activity != null) {
			
			mGridAdapter = new GridAdapter(activity, gridItems);
			
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
						+ gridItems[pos].title, Toast.LENGTH_LONG).show();
	}
}
