// Generated code from Butter Knife. Do not modify!
package com.haroonstudios.newsapitutorial.Adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.haroonstudios.newsapitutorial.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SourcesAdapter$SourcesViewHolder_ViewBinding implements Unbinder {
  private SourcesAdapter.SourcesViewHolder target;

  @UiThread
  public SourcesAdapter$SourcesViewHolder_ViewBinding(SourcesAdapter.SourcesViewHolder target,
      View source) {
    this.target = target;

    target.circleImageView = Utils.findRequiredViewAsType(source, R.id.source_image, "field 'circleImageView'", CircleImageView.class);
    target.textViewName = Utils.findRequiredViewAsType(source, R.id.source_name, "field 'textViewName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SourcesAdapter.SourcesViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.circleImageView = null;
    target.textViewName = null;
  }
}
