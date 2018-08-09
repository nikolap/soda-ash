# soda-ash

Soda-ash is an interface between
clojurescript's [reagent](https://github.com/reagent-project/reagent)
and [semantic-ui-react](http://react.semantic-ui.com/introduction).

## Usage

Add the following stylesheet to your *index.html*:

```html
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.min.css"></link>
```


Put the following in the `:dependencies` vector of your *project.clj*

```clojure
[reagent "0.8.1"]
[soda-ash "0.82.2"]
```

Then require soda-ash in your namespace.

```clojure
(ns foo.bar
  (:require [soda-ash.core :as sa]))
```

### Example

Let's take a look at a modal. In javascript, you'd write something like this:

```jsx
import React from 'react'
import { Button, Header, Image, Modal } from 'semantic-ui-react'

const ModalModalExample = () => (
  <Modal trigger={<Button>Show Modal</Button>}>
    <Modal.Header>Select a Photo</Modal.Header>
    <Modal.Content image>
      <Image wrapped size='medium' src='http://semantic-ui.com/images/avatar2/large/rachel.png' />
      <Modal.Description>
        <Header>Default Profile Image</Header>
        <p>We've found the following gravatar image associated with your e-mail address.</p>
        <p>Is it okay to use this photo?</p>
      </Modal.Description>
    </Modal.Content>
  </Modal>
)

export default ModalModalExample
```

However, in clojurescript with soda-ash, you'd write something like this:

```clojure
(ns foo.bar
  (:require
   [reagent.core :as reagent]
   [soda-ash.core :as sa]))

(defn modal-example []
  [sa/Modal {:trigger (reagent/as-element [sa/Button "Show Modal"])}
   [sa/ModalHeader "Select a Photo"]
   [sa/ModalContent {:image true}
    [sa/Image {:wrapped true
               :size    "medium"
               :src     "http://semantic-ui.com/images/avatar2/large/rachel.png"}]
    [sa/ModalDescription
     [sa/Header "Default Profile Image"]
     [:p "We've found the following gravatar image associated with your e-mail address."]
     [:p "Is it okay to use this photo?"]
     ]]])
```


## Gotchas

* Renamed List to ListSA to avoid confusion with clojure.core/list
* Renamed Comment to CommentSA to avoid confusion with clojure.core/comment

## Related

[using semantic ui with re-frame](https://opensourcery.co.za/2017/02/12/using-semantic-ui-react-with-re-frame/) blog post by [@kennethkalmer](https://github.com/kennethkalmer)

[Sodium](https://github.com/deg/sodium) is a wrapper around soda-ash. Sodium adds two sets of features into the mix, both aimed at making it easier to include Semantic UI in re-frame projects:

1. Utility functions to get values in and out of components.
2. Validity-checking aids to help avoid typos.

## Questions

If you have questions, I can usually be found hanging out in the
[clojurians](http://clojurians.net/) #reagent slack channel (my handle
is [@gadfly361](https://twitter.com/gadfly361)).

# License

Copyright © 2016 Matthew Jaoudi

Distributed under the The MIT License (MIT).
