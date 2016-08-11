package betaout.com.cardflipmatrix;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by puneet on 11/8/16.
 */
public class GridAdapter extends RecyclerView
.Adapter<GridAdapter
.DataObjectHolder> {
    private List<GridItem> tagsModelArrayList= new ArrayList<>();
    private ArrayList<GridItem> mDataset;
    private LayoutInflater mLayoutInflater;


    private  String LOG_TAG = "MyRecyclerViewAdapter";



        Context context;



public  class DataObjectHolder extends RecyclerView.ViewHolder
         {
    TextView tag;
    SquareImageView label;
    LinearLayout layout;

    public DataObjectHolder(View itemView) {
        super(itemView);
        tag = (TextView) itemView.findViewById(R.id.tagName);
        label=(SquareImageView) itemView.findViewById(R.id.label);
        layout=(LinearLayout) itemView.findViewById(R.id.layout);





    }


}



    public GridAdapter(ArrayList<GridItem> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }


    public void setTagList(List<GridItem> tagsModelArrayList) {
        this.tagsModelArrayList = tagsModelArrayList;
        //  this.attendeesImgs=Imgs;
        notifyItemRangeChanged(0, tagsModelArrayList.size());
        notifyDataSetChanged();

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_grid_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {



        holder.tag.setText(mDataset.get(position).getTag());
            holder.label.setBackgroundColor(getBackgroundColor(mDataset.get(position).getTag()));
            System.out.println("color"+mDataset.get(position).getColor());

            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   deleteItem(position);

                }
            });

    }

    public void addItem(GridItem dataObj, int index) {

        mDataset.add(index, dataObj);

        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        if(mDataset.size()>index) {
            mDataset.remove(index);
            notifyItemRemoved(index);
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public int getBackgroundColor(String category) {
        switch (category) {
            case "1":
                return context.getResources().getColor(R.color.nightlife);
            case "2":
                return context.getResources().getColor(R.color.startup);
            case "3":
                return context.getResources().getColor(R.color.music);
            case "4":
                return context.getResources().getColor(R.color.food);
            case "5":
                return context.getResources().getColor(R.color.comedy);
            case "6":
                return context.getResources().getColor(R.color.culture);
            case "7":
                return context.getResources().getColor(R.color.college_events);
            case "8":
                return context.getResources().getColor(R.color.sports);
            case "9":
                return context.getResources().getColor(R.color.experience);
            case "Workshops":
                return context.getResources().getColor(R.color.workshops);
            case "Theatre":
                return context.getResources().getColor(R.color.theatre);
            case "Conferences":
                return context.getResources().getColor(R.color.conference);
            default:
                return context.getResources().getColor(R.color.comedy);
        }
    }
}
