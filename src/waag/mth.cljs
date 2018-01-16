(ns waag.mth)

;;javascript interop
(defn m
  ([selector]
   (js/m selector))
  ([selector attr]
   (js/m selector (clj->js attr)))
  ([selector attr & children]
   (js/m selector (clj->js attr) (clj->js children))))


;;(defn comp [name inputfun] (js-obj "view") inputfun)

(defn margs [args] (m (get args :tag) (get args :props) (get args :val)))

;js-obj with a view property and a function
(defn mcomp [inputfun] (js-obj "view" inputfun))

(defn mcompargs [args] (mcomp (fn [vnode] (margs args))))
;(defn defcomp [inputname args] (mthmacro/macrocompargs inputname args))

(defn mount
  [element component]
  (js/m.mount element component))
