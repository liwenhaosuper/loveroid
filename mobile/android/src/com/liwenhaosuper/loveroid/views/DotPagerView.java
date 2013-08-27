package com.liwenhaosuper.loveroid.views;

import com.liwenhaosuper.loveroid.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DotPagerView extends LinearLayout{
	 private int awc;
	 private LinearLayout.LayoutParams awd;

	  public DotPagerView(Context paramContext)
	  {
	    super(paramContext);
	  }

	  public DotPagerView(Context paramContext, AttributeSet paramAttributeSet)
	  {
	    super(paramContext, paramAttributeSet);
	  }

	  public DotPagerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
	  {
	    super(paramContext, paramAttributeSet, paramInt);
	  }

	  //TODO
	  
	  
	  public void setSelectedDot(int paramInt)
	  {
		  for(int i=0;i<getChildCount();i++){
			  if (i == paramInt){
				  getChildAt(i).setBackgroundResource(R.drawable.popup_page_active);
			  }else{
				  getChildAt(i).setBackgroundResource(R.drawable.popup_page_inactive);
			  }
		  }
	  }
}
