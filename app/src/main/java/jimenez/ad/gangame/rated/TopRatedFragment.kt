package jimenez.ad.gangame.rated

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import jimenez.ad.commons.BR
import jimenez.ad.commons.BaseListFragment
import jimenez.ad.commons.DatBindingRecyclerAdapter
import jimenez.ad.gangame.R
import jimenez.ad.gangame.TopGame
import jimenez.ad.gangame.data.GangameDataSource

class TopRatedFragment : BaseListFragment(){
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return  DatBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)

    }


    override fun onResume() {
        super.onResume()
        showTopRated()
    }

    private fun showTopRated() {
        GangameDataSource
                .getTopRated()
                .subscribe({list ->
                    replaceItems(list)
                }, {error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }

    private fun replaceItems(list: List<TopGame>){
        with(listAdapter as DatBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }


}