package com.br.laurateodoro.meuhotel.ui.cadclientes;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.br.laurateodoro.meuhotel.databinding.FragmentConClienteBinding;
import com.br.laurateodoro.meuhotel.model.Cliente;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Cliente}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConClienteRecyclerViewAdapter extends RecyclerView.Adapter<ConClienteRecyclerViewAdapter.ViewHolder> {

    private final List<Cliente> mValues;

    public ConClienteRecyclerViewAdapter(List<Cliente> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConClienteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getCpf());
        holder.mContentView.setText(mValues.get(position).getNomeHospede());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Cliente mItem;

        public ViewHolder(FragmentConClienteBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}