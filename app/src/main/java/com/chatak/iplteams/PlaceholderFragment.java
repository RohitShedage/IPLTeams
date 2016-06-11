package com.chatak.iplteams;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static String PRODUCT_RETRIEVAL_STATUS = "NOT_STARTED";

    private static ArrayList<Product> ALL_PRODUCTS = new ArrayList<Product>();

    private ListView lvProducts;
    private ProductAdapter productAdapter;
    private ProductClient client;


    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        lvProducts = (ListView) rootView.findViewById(R.id.section_label);
        ArrayList<Product> products = new ArrayList<Product>();
        productAdapter = new ProductAdapter(getContext(), products);
        lvProducts.setAdapter(productAdapter);
        fetchProducts();
        return rootView;
    }

    public void filterProducts() {
        productAdapter.clear();

        for (Product product: ALL_PRODUCTS) {
            if (Integer.parseInt(product.getCakeId()) == getArguments().getInt(ARG_SECTION_NUMBER)) {
                productAdapter.add(product);
            }
        }
        productAdapter.notifyDataSetChanged();
    }

    private void fetchProducts() {
        if(PRODUCT_RETRIEVAL_STATUS.equalsIgnoreCase("NOT_STARTED")) {
            PRODUCT_RETRIEVAL_STATUS = "STARTED";
            client = new ProductClient();
            client.getProducts(new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    if(response != null) {
                        ALL_PRODUCTS.addAll(Product.fromJson(response));
                        PRODUCT_RETRIEVAL_STATUS = "COMPLETED";
                    }
                    filterProducts();
                }
            });
        } else {
            filterProducts();
        }
    }
}