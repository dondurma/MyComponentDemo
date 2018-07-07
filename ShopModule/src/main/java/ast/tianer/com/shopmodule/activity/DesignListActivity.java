package ast.tianer.com.shopmodule.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.smile.ch.common.base.ARouterManager;
import com.smile.ch.common.base.BaseMvcActivity;

import ast.tianer.com.shopmodule.R;

@Route(path = ARouterManager.DesignListActivity)
public class DesignListActivity extends BaseMvcActivity {
    Button btnJump;


    @Override
    protected int getLayoutId() {

        return R.layout.activity_design_list;
    }

    @Override
    protected void initView() {
        initLayout();
        String tag = getIntent().getStringExtra("msg");
//        Toast.makeText(this, tag, Toast.LENGTH_LONG).show();
    }

    private void initLayout() {
        btnJump = findViewById(R.id.btn_jump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发起路由跳转
                ARouter.getInstance()
                        .build(ARouterManager.HomeActivity)
                        .withString("msg", "我是首页进来的")
                        .navigation(DesignListActivity.this, 999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == 666) {
            finish();
        }

    }
}
