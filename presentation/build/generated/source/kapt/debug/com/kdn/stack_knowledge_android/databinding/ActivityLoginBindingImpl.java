package com.kdn.stack_knowledge_android.databinding;
import com.kdn.stack_knowledge_android.R;
import com.kdn.stack_knowledge_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.g_ic_background_t_b, 1);
        sViewsWithIds.put(R.id.g_ic_background_b_t, 2);
        sViewsWithIds.put(R.id.g_ic_background_b_s, 3);
        sViewsWithIds.put(R.id.g_ic_stack_black_logo_t, 4);
        sViewsWithIds.put(R.id.g_ic_stack_black_logo_b, 5);
        sViewsWithIds.put(R.id.g_ic_stack_black_logo_s, 6);
        sViewsWithIds.put(R.id.g_ic_stack_black_logo_e, 7);
        sViewsWithIds.put(R.id.g_black_stack_knowledge_s, 8);
        sViewsWithIds.put(R.id.g_black_stack_knowledge_e, 9);
        sViewsWithIds.put(R.id.v_ic_background_t, 10);
        sViewsWithIds.put(R.id.v_ic_background_b, 11);
        sViewsWithIds.put(R.id.v_black_stack_logo, 12);
        sViewsWithIds.put(R.id.tv_black_stack_knowledge, 13);
        sViewsWithIds.put(R.id.btn_gauth_login_button, 14);
        sViewsWithIds.put(R.id.v_gauth_web_view, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.compose.ui.platform.ComposeView) bindings[14]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (androidx.constraintlayout.widget.Guideline) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[2]
            , (androidx.constraintlayout.widget.Guideline) bindings[1]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (android.widget.TextView) bindings[13]
            , (android.view.View) bindings[12]
            , (androidx.compose.ui.platform.ComposeView) bindings[15]
            , (android.view.View) bindings[11]
            , (android.view.View) bindings[10]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}