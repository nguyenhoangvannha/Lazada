package com.nhanhv.lazada.adapter;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhanhv.lazada.model.trangChu.LoadLoaiSanPham;
import com.nhanhv.lazada.model.entity.LoaiSanPham;
import com.nhanhv.lazada.R;

import java.util.List;

public class ExpandableMenuAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<LoaiSanPham> loaiSanPhams;

    public ExpandableMenuAdapter(Context context, List<LoaiSanPham> loaiSanPhams) {
        this.context = context;
        this.loaiSanPhams = loaiSanPhams;
        loadChilds();
    }

    private void loadChilds() {
        int size = loaiSanPhams.size();
        LoadLoaiSanPham loadLoaiSanPham = new LoadLoaiSanPham();
        for (int i = 0; i < size; i++){
            loaiSanPhams.get(i).setLoaiSanPhams(loadLoaiSanPham.loadListLSPCon(loaiSanPhams.get(i).getmMaLoaiSP()));
        }
    }

    @Override
    public int getGroupCount() {
        return loaiSanPhams.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (loaiSanPhams.get(groupPosition).getLoaiSanPhams().size() > 0){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return loaiSanPhams.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return loaiSanPhams.get(groupPosition).getLoaiSanPhams().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return loaiSanPhams.get(groupPosition).getmMaLoaiSP();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return loaiSanPhams.get(groupPosition).getLoaiSanPhams().get(childPosition).getmMaLoaiSP();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_menu_expand, parent, false);
        TextView textTitle = view.findViewById(R.id.textTitle);
        ImageView imageIcon = view.findViewById(R.id.imageIcon);
        textTitle.setText(loaiSanPhams.get(groupPosition).getmTenLoaiSP());
        if (loaiSanPhams.get(groupPosition).getLoaiSanPhams().size() == 0){
            imageIcon.setVisibility(View.INVISIBLE);
        } else {
            imageIcon.setVisibility(View.VISIBLE);
            if (isExpanded){
                imageIcon.setImageResource(R.drawable.ic_remove_black_24dp);
            } else {
                imageIcon.setImageResource(R.drawable.ic_add_black_24dp);
            }
        }
        int paddingLeft = (int) context.getResources().getDimension(R.dimen._8sdp);
        view.setPadding(paddingLeft,0,0,0);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SecondExpanable childView = new SecondExpanable(context);
        ExpandableMenuAdapter menuAdapter = new ExpandableMenuAdapter(context, loaiSanPhams.get(groupPosition).getLoaiSanPhams());
        childView.setAdapter(menuAdapter);
        childView.setGroupIndicator(null);
        int paddingLeft = (int) context.getResources().getDimension(R.dimen._16sdp);
        childView.setPadding(paddingLeft,0,0,0);
        menuAdapter.notifyDataSetChanged();
        return childView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class SecondExpanable extends ExpandableListView{

        public SecondExpanable(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            int width = size.x;
            int height = size.y;

//            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
