package jimenez.ad.gangame.deals

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import jimenez.ad.commons.BaseListFragment
import jimenez.ad.commons.DatBindingRecyclerAdapter
import jimenez.ad.gangame.BR
import jimenez.ad.gangame.Deal
import jimenez.ad.gangame.R
import jimenez.ad.gangame.data.GangameDataSource
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


class DealsFragment : BaseListFragment(){

    override fun getAdapter(): RecyclerView.Adapter<*> {
       return DatBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GangameDataSource
                .getDeals()
                .subscribe({list ->
                    replaceItems(list)
                }, {error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }

    private fun replaceItems(list: List<Deal>){
        with(listAdapter as DatBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }



}
