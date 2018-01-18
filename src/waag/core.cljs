(ns waag.core
  (:require [waag.mth :as mth]
            [waag.state :as state]

            [waag.homepage :as homepage]
            [waag.mycards :as mycards]
            [waag.mycard :as mycard]
            [waag.newcard :as newcard]))

(enable-console-print!)

;;app
(def app (mth/mcomp
    (fn [vnode]
      (mth/m (case (first (deref state/page))
                          :home homepage/main
                          :login "login"
                          :mycards mycards/main
                          :mycard mycard/main
                          :newcard newcard/main
                          :shop "shop"
                          :settings "settings")))))

(mth/mount (js/document.getElementById "app") app)
