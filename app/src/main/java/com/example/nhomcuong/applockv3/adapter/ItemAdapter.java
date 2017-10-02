package com.example.nhomcuong.applockv3.adapter;

/**
 * Created by sev_user on 8/3/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhomcuong.applockv3.R;
import com.example.nhomcuong.applockv3.activities.MainActivity;
import com.example.nhomcuong.applockv3.model.Item;
import com.example.nhomcuong.applockv3.model.TransferData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sev_user on 8/2/2017.
 */

public class ItemAdapter extends BaseAdapter{
    Context context;
    int myLayout;
    ArrayList<Item> data;
    TransferData mTransferData;
    private List<Item> appListSearch;


    public ItemAdapter(Context context, int myLayout, ArrayList<Item> data,TransferData transferData) {
        this.context = context;
        this.myLayout = myLayout;
        this.data = data;
        this.mTransferData = transferData;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(myLayout,null);
        TextView txtvten=(TextView)view.findViewById(R.id.textView);
        txtvten.setText(data.get(i).getLabel());
        ImageView image=(ImageView)view.findViewById(R.id.imageView);
        image.setImageDrawable(data.get(i).getIcon());
        final CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkBox);
        checkBox.setChecked(data.get(i).getischecked());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isTick=checkBox.isChecked();
                String label,packet;
                String s=String.valueOf(isTick);

                label = data.get(i).getLabel();
                packet=data.get(i).getPacketName();

                mTransferData.tinhtoan(i,packet,isTick,label);

            }
        });

        return view;
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                final FilterResults oReturn = new FilterResults();
                final List<Item> results = new ArrayList<>();
                if (appListSearch == null) {
                    appListSearch = data;
                }
                if (charSequence != null) {
                    if (appListSearch != null && appListSearch.size() > 0) {
                        for (final Item item : appListSearch) {
                            if (item.getLabel().toLowerCase().contains(charSequence.toString())) {
                                results.add(item);
                            }
                        }
                    }
                    oReturn.values = results;
                    oReturn.count = results.size();
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults.count > 0) {
                    MainActivity.setResultsMessage(false);
                } else {
                    MainActivity.setResultsMessage(true);
                }
                data = (ArrayList<Item>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public void setData(ArrayList<Item> data) {
        this.data = data;
    }
}
