package com.udb.dsm.apilabphp;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.udb.dsm.apilabphp.databinding.ItemPersonBinding;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private final ItemPersonBinding itemPersonBinding;

    public PersonViewHolder(View view) {
        super(view);

        itemPersonBinding = ItemPersonBinding.bind(view);
    }

    public void bind(PeopleInfo repo) {
        itemPersonBinding.textPersonName.setText(repo.getName());
        itemPersonBinding.textPersonId.setText(repo.getId());
        itemPersonBinding.textPersonAge.setText(repo.getAge());
        itemPersonBinding.textPersonMobile.setText(repo.getMobile());
        itemPersonBinding.textPersonEmail.setText(repo.getEmail());
    }
}
