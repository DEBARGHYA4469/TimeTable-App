package com.example.debarghya.splashing;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    String group[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
    String child[][]={{"08-09 CL202  Fluid Mechanics 4G4","10-11 CL231  Quantum Chem 4103","11-12 HS214  Cultural Theory 1G1","12-01 CS205M CSMinor Core 1","05-06 CL201  Chem Calc 4G4"},{"08-09 MA201 Maths L4","09-10 CL202 Fluid Mech 4G4","11-12 CH231 Quantum chem 4103","04-05 CL201  Chem Calc 4G4"},{"09-10 MA201  Maths L4","10-11 CL202  Fluid Mechanics 4G4","12-01 CS205M CS Minor Core1","03-04 CL201  Chem Calc 4G4"},{"09-10 HS214 Cultural Theory 1G1","10-11 MA201 Maths L4","11-12 CL202 Fluid Mechanics 4G4","04-06 CH221 Organic Chem 4103"},{"9-10 CH231  Quantum Chem 4103","10-11 HS214  Cultural Theory 1G1","11-12 MA201  Maths L4","12-01 CS205M CS Minor Core1","03-05  CH221  Organic Chem 4103"}};

    Context context;
    public ExpandableListViewAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getGroupCount() {
        return group.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView=new TextView(context);
        textView.setText(group[groupPosition]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(40);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView=new TextView(context);
        textView.setText(child[groupPosition][childPosition]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.GRAY);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
