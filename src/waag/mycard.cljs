(ns waag.mycard
  (:require [waag.mth :as mth]
            [waag.state :as state]
            [waag.reusable :as reusable]))


;;card
(def card (mth/mcomp
    (fn [vnode] (mth/m ".card.card-full"
                       [(mth/m ".card-top" vnode.attrs.card.category)
                        (mth/m ".card-top" vnode.attrs.card.name)
                        (mth/m ".card-score" vnode.attrs.card.score)]))))

;;homepage
(def main (mth/mcomp
    (fn [vnode] (mth/m ".page"
                       [(mth/m reusable/backbutton {:onclick (fn [] (state/gotoPage :mycards))})
                        (mth/m card {:card (state/getCardById (first (state/getPageParams)))})]))))
