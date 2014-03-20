(require 'android)

(+ 1 2)
(setq now (find-view-by-id 2131296272))

(setq green 65280)
(setq red 16711680)
(setq blue 255)

(set-view-background-color now blue)
(sleep 1000)
(set-view-background-color now red)
(sleep 1000)
(set-view-background-color now green)
(sleep 1000)
(set-view-background-color now 0)
