package ru.payts.materius;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabBehavior extends FloatingActionButton.Behavior {


    public FabBehavior(Context context, AttributeSet attrs) {
        super();
    }


    @SuppressLint("RestrictedApi")
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                               @NonNull FloatingActionButton fab,
                               @NonNull View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, fab, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed, type);
        //child -> Floating Action Button
        if (dyConsumed > 0) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            int fab_bottomMargin = layoutParams.bottomMargin;
            fab.animate().translationY(fab.getHeight() + fab_bottomMargin).setInterpolator(new LinearInterpolator()).start();
        } else if (dyConsumed < 0) {
            fab.animate().translationY(0).setInterpolator(new LinearInterpolator()).start();
        }

//        if (fab.getVisibility() == View.VISIBLE && dyConsumed > 0) {
//            fab.setVisibility(View.INVISIBLE);
//        } else if (fab.getVisibility() == View.INVISIBLE && dyConsumed < 0) {
//            fab.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public boolean onStartNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull FloatingActionButton child,
            @NonNull View directTargetChild,
            @NonNull View target,
            int axes,
            int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
}
