package com.example.twitterfeed.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    public V mMvpView;

    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }
}
