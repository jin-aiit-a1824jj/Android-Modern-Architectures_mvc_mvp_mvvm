package a1824jj.jp.ac.aiit.modernarchitectures_sampel.mvc;

import java.util.ArrayList;
import java.util.List;

import a1824jj.jp.ac.aiit.modernarchitectures_sampel.model.CountriesService;
import a1824jj.jp.ac.aiit.modernarchitectures_sampel.model.Country;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesController {

    private MVCActivity view;
    private CountriesService service;

    public CountriesController(MVCActivity view){
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }

    private void fetchCountries(){
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> countries) {
                        List<String> countryNames = new ArrayList<>();
                        for(Country country: countries){
                            countryNames.add(country.countryName);
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                    }
                });
    }

    public void onRefresh(){
        fetchCountries();
    }
}
