package com.chatak.iplteams;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final ArrayList<Product> products = getAllProducts();

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
        ListView textView = (ListView) rootView.findViewById(R.id.section_label);

        textView.setAdapter(new ProductAdapter(getContext(), filterProducts()));
        return rootView;
    }

    public ArrayList<Product> filterProducts() {
        ArrayList<Product> filteredProducts = new ArrayList<Product>();

        for (Product product: products) {
            if (Integer.parseInt(product.getCakeId()) == getArguments().getInt(ARG_SECTION_NUMBER)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        products.add(new Product("1","17 Fake Street","500 gram", 251));
        products.add(new Product("1","17 Fake Street","500 gram", 252));
        products.add(new Product("1","17 Fake Street","500 gram", 253));
        products.add(new Product("1","17 Fake Street","500 gram", 254));
        products.add(new Product("1","17 Fake Street","500 gram", 255));
        products.add(new Product("1","17 Fake Street","500 gram", 256));
        products.add(new Product("1","17 Fake Street","500 gram", 257));
        products.add(new Product("1","17 Fake Street","500 gram", 258));
        products.add(new Product("1","17 Fake Street","500 gram", 259));
        products.add(new Product("1","17 Fake Street","500 gram", 260));
        products.add(new Product("2","17 Fake Street","500 gram", 261));
        products.add(new Product("2","17 Fake Street","500 gram", 262));
        products.add(new Product("2","17 Fake Street","500 gram", 263));
        products.add(new Product("2","17 Fake Street","500 gram", 264));
        products.add(new Product("2","17 Fake Street","500 gram", 265));
        products.add(new Product("2","17 Fake Street","500 gram", 266));
        products.add(new Product("2","17 Fake Street","500 gram", 267));
        products.add(new Product("2","17 Fake Street","500 gram", 268));
        products.add(new Product("2","17 Fake Street","500 gram", 269));
        products.add(new Product("2","17 Fake Street","500 gram", 270));
        products.add(new Product("3","17 Fake Street","500 gram", 271));
        products.add(new Product("3","17 Fake Street","500 gram", 272));
        products.add(new Product("3","17 Fake Street","500 gram", 273));
        products.add(new Product("3","17 Fake Street","500 gram", 274));
        products.add(new Product("3","17 Fake Street","500 gram", 275));
        products.add(new Product("3","17 Fake Street","500 gram", 276));
        products.add(new Product("3","17 Fake Street","500 gram", 277));
        products.add(new Product("3","17 Fake Street","500 gram", 278));
        products.add(new Product("3","17 Fake Street","500 gram", 279));
        products.add(new Product("3","17 Fake Street","500 gram", 280));

        return products;
    }
}