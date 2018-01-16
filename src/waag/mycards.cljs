(ns waag.mycards
  (:require [waag.mth :as mth]
            [waag.state :as state]))


;;card
(def card (mth/mcomp
    (fn [vnode] (mth/m ".card"
                       {:onclick (fn [] (state/gotoPage :mycard vnode.attrs.card.id))}
                       [(mth/m ".card-top" vnode.attrs.card.name)
                        (mth/m ".card-score" vnode.attrs.card.score)]))))

;;category
(def category (mth/mcomp
    (fn [vnode] (mth/m ".category"
                       [(mth/m ".card-top" (first vnode.attrs.category))
                        (map (fn [c] (mth/m card {:card c}))
                             (second vnode.attrs.category))]))))

;;homepage
(def main (mth/mcomp
    (fn [vnode]
      (mth/m ".page" (map (fn [c] (mth/m category {:category c}))
                          (state/getCardsByCategory))))))
