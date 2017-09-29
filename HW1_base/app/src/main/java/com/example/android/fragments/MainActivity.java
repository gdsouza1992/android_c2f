/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends FragmentActivity 
        implements HeadlinesFragment.OnHeadlineSelectedListener {

    private int mcurrentPosition=-1;
    private boolean conversionIndex=false;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

    }

    public void onArticleSelected(int position) {
        if (position == 2) {
           // The user selected the headline of an article from the HeadlinesFragment

            // Capture the article fragment from the activity layout
            ArticleFragment articleFrag = (ArticleFragment)
                    getSupportFragmentManager().findFragmentById(R.id.article_fragment);
            articleFrag.updateArticleView(position);

            TextView article = (TextView) findViewById(R.id.article);
            article.setText(Ipsum.Articles[position]);


        } else if (position < 2) {
            ConversionFragment convrFragment = new ConversionFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            transaction.replace(R.id.article_fragment, convrFragment);
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();

        } /*else{
            TextView article = (TextView) findViewById(R.id.article);
            article.setText(Ipsum.Articles[position]);

        } */

        //to store current position value in order to perform conversion calculations
        mcurrentPosition=position;
    }

    /*{
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

            // Call a method in the ArticleFragment to update its content
        articleFrag.updateArticleView(position);

        TextView article = (TextView) findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
       //setContentView(R.layout.conversion);

    } */

    //reference from simple android application's "add a on-click action"
    public void display(View view){
        TextView msgTextView = (TextView) findViewById(R.id.mytextview);
        EditText msgTextField = (EditText) findViewById(R.id.mytextfield);

        double input=Double.parseDouble(msgTextField.getText().toString());
        double conversion=0;
        String output="";

        if(mcurrentPosition==0){
            conversion=input*9/5+32;
            output=String.format("Temperature %.02f(C) is %.02f(F)",input,conversion);
        }else {
            conversion=(input-32)*5/9;
            output=String.format("Temperature %.02f(F) is %.02f(C)",input,conversion);
        }
        msgTextView.setText(output);
        msgTextField.setText(null);
    }
}