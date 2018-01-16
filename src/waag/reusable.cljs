(ns waag.reusable
  (:require [waag.mth :as mth]))


;;card
(def backbutton (mth/mcomp
    (fn [vnode] (mth/m ".button-back"
                       {:onclick vnode.attrs.onclick}
                       "back"))))
