(ns waag.core
  (:require [waag.mth :as mth]
            [waag.state :as state]

            [waag.homepage :as homepage]
            [waag.mycards :as mycards]
            [waag.mycard :as mycard]))

(enable-console-print!)

;;app state


;;homepage
(def homepage (mth/mcomp
    (fn [vnode]
      (mth/m ".homepage" "homepage"))))

;;app
(def app (mth/mcomp
    (fn [vnode]
      (mth/m (case (first (deref state/page))
                          :home homepage/main
                          :login "login"
                          :mycards mycards/main
                          :mycard mycard/main
                          :shop "shop"
                          :settings "settings")))))




(mth/mount (js/document.getElementById "app") app)
