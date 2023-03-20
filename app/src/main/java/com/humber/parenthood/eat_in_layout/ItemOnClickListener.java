package com.humber.parenthood.eat_in_layout;

import androidx.cardview.widget.CardView;

public interface ItemOnClickListener {
    void onClick(ItemModel item);

    void onLongClick(ItemModel notes, CardView cardView);
}
