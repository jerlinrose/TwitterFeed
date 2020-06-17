package com.example.twitterfeed.ui.base;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mVpView);

    void onDetach();
}
