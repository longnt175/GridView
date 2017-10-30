package viewpager.gridview.android.viewpagerwithindicator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{

	Context context;
	
	int images[] = { R.drawable.ic_launcher, R.drawable.img_linux,
			R.drawable.img_windows, R.drawable.ic_launcher};
	
	public class ViewHolder {
		public ImageView imageView;
		public TextView textTitle;
	}
	
	private GridItem[] items;
	private LayoutInflater mInflater;
	
	public GridAdapter(Context context, GridItem[] locations) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		items = locations;
	}
	
	public GridItem[] getItems() {
		return items;
	}

	public void setItems(GridItem[] items) {
		this.items = items;
	}

	@Override
	public int getCount() {
		if(items != null) {
			return items.length;
		}
		return 0;
	}

	@Override
	public Object getItem(int pos) {
		if(items != null && pos >= 0 && pos < getCount()) {
			return items[pos];
		}
		return null;
	}

	@Override
	public long getItemId(int pos) {
		if(items != null && pos >= 0 && pos < getCount()) {
			return items[pos].id;
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
		
		GridItem gridItem = items[pos];
		setCatImage(pos, viewHolder, gridItem.title);
		
		return view;
	}

	private void setCatImage(int pos, ViewHolder viewHolder, String title) {
		viewHolder.imageView.setImageResource(images[pos]);
		viewHolder.textTitle.setText(title);
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}
}
