// Generated code from Butter Knife. Do not modify!
package com.haroonstudios.newsapitutorial.Activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.haroonstudios.newsapitutorial.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import link.fls.swipestack.SwipeStack;

public class ListStackActivity_ViewBinding implements Unbinder {
  private ListStackActivity target;

  @UiThread
  public ListStackActivity_ViewBinding(ListStackActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListStackActivity_ViewBinding(ListStackActivity target, View source) {
    this.target = target;

    target.swipeStack = Utils.findRequiredViewAsType(source, R.id.swipeStack, "field 'swipeStack'", SwipeStack.class);
    target.relativeLayoutNoFound = Utils.findRequiredViewAsType(source, R.id.relativeLayoutNoFound, "field 'relativeLayoutNoFound'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListStackActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.swipeStack = null;
    target.relativeLayoutNoFound = null;
  }
}
