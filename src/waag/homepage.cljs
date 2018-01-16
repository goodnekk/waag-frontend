(ns waag.homepage
  (:require [waag.mth :as mth]
            [waag.state :as state]))

;;homepage
(def main (mth/mcomp
    (fn [vnode]
      (mth/m ".page"
             {:onclick (fn [] (state/gotoPage :mycards))}
             "waag"))))
