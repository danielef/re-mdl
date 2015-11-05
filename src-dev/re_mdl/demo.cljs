(ns ^:figwheel-always re-mdl.demo
  (:require
   [re-mdl.core]
   [reagent.core :as r]
   [re-mdl.components.badge :as badge]
   [re-mdl.components.button :as button]
   [re-mdl.components.card :as card]
   [re-mdl.components.grid :as grid]
   [re-mdl.components.layout :as layout]
   [re-mdl.components.loading :as loading]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (r/atom {:text "Hello world!"}))


(defn badge-demo []
  [:div.badge-demo
   [badge/badge
    :badge-label "3"
    :child
    "Badge"]
   [badge/badge
    :badge-label "3"
    :no-background? true
    :child
    "No Background"]
   [badge/badge
    :badge-label "3"
    :overlap? true
    :child
    "Overlap"]
   [badge/badge
    :badge-label "♥"
    :icon? true
    :child
    "account_box"]])

(defn button-demo []
  [:div.button-demo
   [button/button
    :label "Button"]
   [button/button
    :primary? true
    :label "Primary"]
   [button/button
    :raised? true
    :label "Raised"]
   [button/button
    :fab? true
    :label "Fab"]
   [button/button
    :mini-fab? true
    :label [:i.material-icons "add"]]
   [button/button
    :ripple-effect? true
    :label "Ripple"]])

(defn card-demo []
  [card/card
   :shadow 2
   :children
   [[card/title
     :expand? true
     :header :h4
     :text "Card"]
    [card/actions
     :border? true
     :children
     [[:a.mdl-button.mdl-button--colored.mdl-js-button.mdl-js-ripple-effect
       "Action"]
      ]]]])

(defn grid-demo [& kids]
  [grid/grid
   :children
   (into []
         (for [kid kids]
           [grid/cell
            :children
            [kid]]))])

(defn mega-footer-demo []
  [layout/mega-footer
   :logo "Title"
   :middle
   [[layout/mega-drop-down
     :heading "Features"
     :children
     [[:a {:href "#"} "About"]
      [:a {:href "#"} "Terms"]
      [:a {:href "#"} "Partners"]
      [:a {:href "#"} "Updates"]]]
    [layout/mega-drop-down
     :heading "Details"
     :children
     [[:a {:href "#"} "Specs"]
      [:a {:href "#"} "Tools"]
      [:a {:href "#"} "Resources"]]]
    [layout/mega-drop-down
     :heading "Technology"
     :children
     [[:a {:href "#"} "How it works"]
      [:a {:href "#"} "Patterns"]
      [:a {:href "#"} "Usage"]
      [:a {:href "#"} "Products"]
      [:a {:href "#"} "Contracts"]]]
    [layout/mega-drop-down
     :heading "FAQ"
     :children
     [[:a {:href "#"} "Questions"]
      [:a {:href "#"} "Answers"]
      [:a {:href "#"} "Contact"]]]]
   :bottom
   [[layout/mega-link-list
    :children
    [[:a {:href "#"} "Help"]
     [:a {:href "#"} "Privacy & Terms"]]]]])

(defn mini-footer-demo []
  [layout/mini-footer
   :logo "Title"
   :left
   [[layout/mini-link-list
     :children
     [[:a {:href "#"} "Help"]
      [:a {:href "#"} "Privacy & Terms"]]]]])

(defn tab-demo []
  [layout/tabs
   :children
   [[layout/tab-bar
     :children
     [[layout/tab
      :href "#starks-panel"
       :is-active? true
       :content "Starks"]
      [layout/tab
       :href "#lannisters-panel"
       :is-active? true
       :content "Lannisters"]
      [layout/tab
       :href "#targaryens-panel"
       :is-active? true
       :content "Targaryens"]]]
    [layout/tabs-panel
     :is-active? true
     :id "starks-panel"
     :children
     [[:ul
       [:li "Eddard"]
       [:li "Catelyn"]
       [:li "Rob"]]]]
    [layout/tabs-panel
     :id "lannisters-panel"
     :children
     [[:ul
       [:li "Tywin"]
       [:li "Cersei"]
       [:li "Jamie"]]]]
    [layout/tabs-panel
     :id "targaryens-panel"
     :children
     [[:ul
       [:li "Viserys"]
       [:li "Danerys"]]]]]])

(defn demo-layout []
  (let [kids (r/children (r/current-component))]
    [:div.mdl-wrapper
     [layout/layout
      :fixed-header? true
      :children
      [[layout/header
        :children
        [[layout/header-row
          :children
          [[layout/title :label "Material Design Lite"]
           [layout/spacer]
           [layout/nav
            :children
            [[layout/nav-link :href "/#/" :content "Home"]
             [layout/nav-link :href "/#/about" :content "About"]]]]]]]
       [layout/drawer
        :children
        [[layout/title :label "Material Design Lite"]
         [layout/nav
          :children
          [[layout/nav-link :href "/#/" :content "Home"]
           [layout/nav-link :href "/#/about" :content "About"]]]]]
       [layout/content
        :children kids]]]]))


(defn loading-demo []
  [loading/progress
   :indeterminate? true])




(defn app-view []
  [:div ;; extra wrapper div so mdl doesn't clobber the root
   [demo-layout
    [grid-demo
     [badge-demo]
     [button-demo]
     [card-demo]
     [tab-demo]
     [loading-demo]]
    [mega-footer-demo]
    [mini-footer-demo]]])


(defn ^:export run []
  (r/render [app-view]
            (js/document.getElementById "app")))



(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  ;; (run)
  (run))

(run)
