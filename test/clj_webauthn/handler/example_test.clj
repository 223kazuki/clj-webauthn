(ns clj-webauthn.handler.example-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [ring.mock.request :as mock]
            [clj-webauthn.handler.example :as example]))

(deftest smoke-test
  (testing "example page exists"
    (let [handler  (ig/init-key :clj-webauthn.handler/example {})
          response (handler (mock/request :get "/example"))]
      (is (= :ataraxy.response/ok (first response)) "response ok"))))
