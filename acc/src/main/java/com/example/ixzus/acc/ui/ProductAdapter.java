package com.example.ixzus.acc.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ixzus.acc.R;
import com.example.ixzus.acc.data.db.entity.Product;
import com.example.ixzus.acc.databinding.ProductItemBinding;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

/**
 * Created by huan on 2017/11/14.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<? extends Product> mListData;

    @Nullable
    private final ProductClickCallback mCallBack;

    public ProductAdapter(@Nullable ProductClickCallback mCallBack) {
        this.mCallBack = mCallBack;
    }

    public void setmListData(final List<? extends Product> listData) {
        if (mListData == null) {
            this.mListData = listData;
            notifyItemRangeInserted(0, mListData.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mListData.size();
                }

                @Override
                public int getNewListSize() {
                    return listData.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return Objects.equals(mListData.get(oldItemPosition).get_id(), listData.get(newItemPosition).get_id());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Product oldProduct = mListData.get(oldItemPosition);
                    Product newProduct = listData.get(newItemPosition);
                    return Objects.equals(oldProduct.get_id(), newProduct.get_id())
                            && Objects.equals(oldProduct.getCreatedAt(), newProduct.getCreatedAt())
                            && Objects.equals(oldProduct.getDesc(), newProduct.getDesc())
                            && Objects.equals(oldProduct.getPublishedAt(), newProduct.getPublishedAt())
                            && Objects.equals(oldProduct.getSource(), newProduct.getSource())
                            && Objects.equals(oldProduct.getType(), newProduct.getType())
                            && Objects.equals(oldProduct.getUrl(), newProduct.getUrl())
                            && oldProduct.isUsed() == newProduct.isUsed()
                            && Objects.equals(oldProduct.getWho(), newProduct.getWho())
//                            && (oldProduct.getImages().size() == newProduct.getImages().size()
//                            && oldProduct.getImages().containsAll(newProduct.getImages()))
                            ;
                }
            });
            mListData = listData;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProductItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.product_item, parent, false);
        binding.setCallback(mCallBack);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.binding.setProduct(mListData.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        final ProductItemBinding binding;

        public ProductViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
