package gy.myproject.method;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arialyy.frame.util.show.T;

import java.util.List;

/**
 * Created by jiang on 16/8/29.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {


    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public BaseAdapter(Context context, List<T> datas, int layoutId)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(final ViewGroup parent, int viewType)
    {
        BaseViewHolder viewHolder = BaseViewHolder.get(mContext, parent,parent,viewType, mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position)
    {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(BaseViewHolder holder, T t);

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    public void refresh(List<T> items) {
        if (items != null) {
            this.mDatas = items;
            notifyDataSetChanged();
        }
    }
}