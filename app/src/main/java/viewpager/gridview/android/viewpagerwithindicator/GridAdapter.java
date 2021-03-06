package viewpager.gridview.android.viewpagerwithindicator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {

	Context context;
	
	public class ViewHolder {
		public ImageView imageView;
		public TextView textTitle;
	}

	private List<Event> items;
	private LayoutInflater mInflater;

	public GridAdapter(Context context, List<Event> items) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		this.items = items;
	}


	@Override
	public int getCount() {
		if(items != null) {
			return items.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int pos) {
		if(items != null && pos >= 0 && pos < getCount()) {
			return items.get(pos);
		}
		return null;
	}

	@Override
	public long getItemId(int pos) {
		if(items != null && pos >= 0 && pos < getCount()) {
			return pos;
		}
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		
		View view = convertView;
		ViewHolder viewHolder;
		
		if(view == null) {
			
			view = mInflater.inflate(R.layout.item, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) view.findViewById(R.id.grid_item_image);
			viewHolder.textTitle = (TextView) view.findViewById(R.id.grid_item_label);
			view.setTag(viewHolder);
			
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}


		setCatImage(viewHolder, items.get(pos).getIncidentName());
		
		return view;
	}

	private void setCatImage(ViewHolder viewHolder, String title) {
		viewHolder.imageView.setImageResource(R.drawable.fire);
		viewHolder.textTitle.setText(title);
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}
}
