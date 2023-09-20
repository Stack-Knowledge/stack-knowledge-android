// Generated by view binder compiler. Do not edit!
package com.kdn.stack_knowledge_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kdn.stack_knowledge_android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline gTvBlackStackKnowledgeB;

  @NonNull
  public final Guideline gTvBlackStackKnowledgeE;

  @NonNull
  public final Guideline gTvBlackStackKnowledgeS;

  @NonNull
  public final Guideline gTvBlackStackKnowledgeT;

  @NonNull
  public final Guideline gVBlackStackLogoB;

  @NonNull
  public final Guideline gVBlackStackLogoS;

  @NonNull
  public final Guideline gVBlackStackLogoT;

  @NonNull
  public final TextView tvBlackStackKnowledge;

  @NonNull
  public final View vBlackStackLogo;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline gTvBlackStackKnowledgeB, @NonNull Guideline gTvBlackStackKnowledgeE,
      @NonNull Guideline gTvBlackStackKnowledgeS, @NonNull Guideline gTvBlackStackKnowledgeT,
      @NonNull Guideline gVBlackStackLogoB, @NonNull Guideline gVBlackStackLogoS,
      @NonNull Guideline gVBlackStackLogoT, @NonNull TextView tvBlackStackKnowledge,
      @NonNull View vBlackStackLogo) {
    this.rootView = rootView;
    this.gTvBlackStackKnowledgeB = gTvBlackStackKnowledgeB;
    this.gTvBlackStackKnowledgeE = gTvBlackStackKnowledgeE;
    this.gTvBlackStackKnowledgeS = gTvBlackStackKnowledgeS;
    this.gTvBlackStackKnowledgeT = gTvBlackStackKnowledgeT;
    this.gVBlackStackLogoB = gVBlackStackLogoB;
    this.gVBlackStackLogoS = gVBlackStackLogoS;
    this.gVBlackStackLogoT = gVBlackStackLogoT;
    this.tvBlackStackKnowledge = tvBlackStackKnowledge;
    this.vBlackStackLogo = vBlackStackLogo;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.g_tv_black_stack_knowledge_b;
      Guideline gTvBlackStackKnowledgeB = ViewBindings.findChildViewById(rootView, id);
      if (gTvBlackStackKnowledgeB == null) {
        break missingId;
      }

      id = R.id.g_tv_black_stack_knowledge_e;
      Guideline gTvBlackStackKnowledgeE = ViewBindings.findChildViewById(rootView, id);
      if (gTvBlackStackKnowledgeE == null) {
        break missingId;
      }

      id = R.id.g_tv_black_stack_knowledge_s;
      Guideline gTvBlackStackKnowledgeS = ViewBindings.findChildViewById(rootView, id);
      if (gTvBlackStackKnowledgeS == null) {
        break missingId;
      }

      id = R.id.g_tv_black_stack_knowledge_t;
      Guideline gTvBlackStackKnowledgeT = ViewBindings.findChildViewById(rootView, id);
      if (gTvBlackStackKnowledgeT == null) {
        break missingId;
      }

      id = R.id.g_v_black_stack_logo_b;
      Guideline gVBlackStackLogoB = ViewBindings.findChildViewById(rootView, id);
      if (gVBlackStackLogoB == null) {
        break missingId;
      }

      id = R.id.g_v_black_stack_logo_s;
      Guideline gVBlackStackLogoS = ViewBindings.findChildViewById(rootView, id);
      if (gVBlackStackLogoS == null) {
        break missingId;
      }

      id = R.id.g_v_black_stack_logo_t;
      Guideline gVBlackStackLogoT = ViewBindings.findChildViewById(rootView, id);
      if (gVBlackStackLogoT == null) {
        break missingId;
      }

      id = R.id.tv_black_stack_knowledge;
      TextView tvBlackStackKnowledge = ViewBindings.findChildViewById(rootView, id);
      if (tvBlackStackKnowledge == null) {
        break missingId;
      }

      id = R.id.v_black_stack_logo;
      View vBlackStackLogo = ViewBindings.findChildViewById(rootView, id);
      if (vBlackStackLogo == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, gTvBlackStackKnowledgeB,
          gTvBlackStackKnowledgeE, gTvBlackStackKnowledgeS, gTvBlackStackKnowledgeT,
          gVBlackStackLogoB, gVBlackStackLogoS, gVBlackStackLogoT, tvBlackStackKnowledge,
          vBlackStackLogo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}