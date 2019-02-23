package com.nhanhv.lazada.view.dangnhap.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhanhv.lazada.R;
import com.nhanhv.lazada.customview.PasswordEdittext;
import com.nhanhv.lazada.model.entity.NhanVien;
import com.nhanhv.lazada.presenter.dangky.DangKyPresenter;
import com.nhanhv.lazada.view.dangnhap.DangKyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangKyFragment extends Fragment implements DangKyView, View.OnClickListener, View.OnFocusChangeListener {
    DangKyPresenter dangKyPresenter;
    Button buttonRegister;
    TextInputEditText editName;
    TextInputEditText editEmail;
    PasswordEdittext editPass;
    PasswordEdittext editRePass;
    SwitchCompat switchEmail;
    TextInputLayout inputName;
    TextInputLayout inputEmail;
    TextInputLayout inputPass;
    TextInputLayout inputRePass;

    public DangKyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dang_ky, container, false);
        init(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void init(View view) {
        buttonRegister = view.findViewById(R.id.buttonRegister);
        editName = view.findViewById(R.id.editFullName);
        editEmail = view.findViewById(R.id.editEmail);
        editPass = view.findViewById(R.id.editPassword);
        editRePass = view.findViewById(R.id.editPasswordRe);
        switchEmail = view.findViewById(R.id.switchEmail);
        inputName = view.findViewById(R.id.textInputName);
        inputEmail = view.findViewById(R.id.textInputEmail);
        inputPass = view.findViewById(R.id.textInputPass);
        inputRePass = view.findViewById(R.id.textInputRePass);

        buttonRegister.setOnClickListener(this);
        editName.setOnFocusChangeListener(this);
        editEmail.setOnFocusChangeListener(this);
        editPass.setOnFocusChangeListener(this);
        editRePass.setOnFocusChangeListener(this);
        dangKyPresenter = new DangKyPresenter(this);
    }

    @Override
    public void dangKyThanhCong() {
        Toast.makeText(getContext(), getString(R.string.msg_reg_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dangKyThatBai() {
        Toast.makeText(getContext(), getString(R.string.msg_reg_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRegister:
                dangKy();
                break;
        }
    }

    private void dangKy() {
        String hoTen = getStr(editName);
        String email = getStr(editEmail);
        String matKhau = getStr(editPass);
        String nhapLaiMatKhau = getStr(editRePass);
        boolean emailDocQuyen = switchEmail.isChecked();

        NhanVien nhanVien = new NhanVien(email, matKhau, hoTen, emailDocQuyen + "");
        nhanVien.setMaLoaiNV(2);
        dangKyPresenter.thucHienDangKy(nhanVien);
    }


    private String getStr(EditText editText) {
        return editText.getText().toString();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            switch (v.getId()) {
                case R.id.editFullName:
                    break;
                case R.id.editEmail:
                    break;
                case R.id.editPassword:
                    break;
                case R.id.editPasswordRe:
                    break;
            }
    }
}
