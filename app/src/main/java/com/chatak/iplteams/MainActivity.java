package com.chatak.iplteams;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }///

    public static class PlaceholderFragment extends Fragment {
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
                //if (Integer.parseInt(product.getCakeId()) == Integer.parseInt(getArguments().getString(ARG_SECTION_NUMBER))) {
                    filteredProducts.add(product);
                //}
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
