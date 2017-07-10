//package com.example.vmm408.privbankretrofitproject.adapter;
//
//import android.content.Context;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.NonNull;
//import android.widget.ArrayAdapter;
//import android.widget.Filter;
//import android.widget.Filterable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomArrayAdapter extends ArrayAdapter implements Filterable {
//    private List<String> mStringListOrigin;
//    private List<String> mStringListFilter;
//    private CustomFilter mCustomFilter;
//
//    public CustomArrayAdapter(@NonNull Context context,
//                              @LayoutRes int resource,
//                              @NonNull List objects) {
//        super(context, resource, objects);
//        mStringListOrigin = objects;
//        mStringListFilter = objects;
//    }
//
//    @NonNull
//    @Override
//    public Filter getFilter() {
//        if (mCustomFilter == null) mCustomFilter = new CustomFilter();
//        return mCustomFilter;
//    }
//
//    private class CustomFilter extends Filter {
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            FilterResults results = new FilterResults();
//            results.count = findUsersInList(constraint).size();
//            results.values = findUsersInList(constraint);
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            mStringListOrigin = (List<String>) results.values;
//            notifyDataSetChanged();
//        }
//
//        private List<String> findUsersInList(CharSequence constraint) {
//            List<String> stringList = new ArrayList<>();
//            for (int i = 0; i < mStringListFilter.size(); i++) {
//                if (isUserInList(i, constraint)) stringList.add(mStringListFilter.get(i));
//            }
//            return stringList;
//        }
//
//        private boolean isUserInList(int i, CharSequence constraint) {
//            return mStringListFilter.get(i).toLowerCase()
//                    .contains(constraint.toString().toLowerCase());
//        }
//    }
//}
