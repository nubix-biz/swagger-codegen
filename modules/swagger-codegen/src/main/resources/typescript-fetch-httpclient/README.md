# TypeScript-Fetch-HttpClient

This generator creates TypeScript/JavaScript client that utilizes [Fetch API](https://fetch.spec.whatwg.org/) with the Aurelia HttpClient. The generated Node module can be used in the following environments:

Environment
* Node.js
* Webpack
* Browserify

Language level
* ES5 - you must have a Promises/A+ library installed
* ES6

Module system
* CommonJS
* ES6 module system

It can be used in both TypeScript and JavaScript. In TypeScript, the definition should be automatically resolved via `package.json`. ([Reference](http://www.typescriptlang.org/docs/handbook/typings-for-npm-packages.html))

### Installation ###

`swagger-codegen` does not generate JavaScript directly. The generated Node module comes with `package.json` that bundles `typescript` and `typings` so it can self-compile during `prepublish` stage. The should be run automatically during `npm install` or `npm publish`.

CAVEAT: Due to [privilege implications](https://docs.npmjs.com/misc/scripts#user), `npm` would skip all scripts if the user is `root`. You would need to manually run it with `npm run prepublish` or run `npm install --unsafe-perm`.

#### NPM ####
You may publish the module to NPM. In this case, you would be able to install the module as any other NPM module. It maybe useful to use [scoped packages](https://docs.npmjs.com/misc/scope).

You can also use `npm link` to link the module. However, this would not modify `package.json` of the installing project, as such you would need to relink every time you deploy that project.

You can also directly install the module using `npm install file_path`. If you do `npm install file_path --save`, NPM will save relative path to `package.json`. In this case, `npm install` and `npm shrinkwrap` may misbehave. You would need to manually edit `package.json` and replace it with absolute path.

Regardless of which method you deployed your NPM module, the ES6 module syntaxes are as follows:
```
import * as localName from 'npmName';
import {operationId} from 'npmName';
```
The CommonJS syntax is as follows:
```
import localName = require('npmName');
```

#### Direct copy/symlink ####
You may also simply copy or symlink the generated module into a directory under your project. The syntax of this is as follows:

With ES6 module syntax, the following syntaxes are supported:
```
import * as localName from './symlinkDir';
import {operationId} from './symlinkDir';
```
The CommonJS syntax is as follows:
```
import localName = require('./symlinkDir')';
```

#### Usage of generated Code ####

```
  const api = client.LuminaireApiFactory( );
  // get 10 Luminaires from server
  api.luminaireGetLuminaires({size: 10}).then((response: client.Luminaire[]): any => {
          response.forEach((clum: client.Luminaire) => {
              // do something with the data objects from the server
          });
      }
  }).catch((error): any => {
      // error handling
  });
```

#### Generation ####
```
swagger-codegen generate -i swagger.json -l typescript-fetch -o tmp/ -t httpclient/
```
