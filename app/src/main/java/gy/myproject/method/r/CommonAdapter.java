package wrw.wai.hairdressing_reservation.method.r;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

import wrw.wai.hairdressing_reservation.method.r.base.ItemViewDelegate;
import wrw.wai.hairdressing_reservation.method.r.base.ViewHolder;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, List<T> datas, final int layoutId) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);

    public void refresh(List<T> items) {
        if (items != null) {
            this.mDatas = items;
            notifyDataSetChanged();
        }
    }
}
