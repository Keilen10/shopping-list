// Change this name on every release, or installed copies keep the old files.
var CACHE = 'shopping-list-v0.0.1';
var FILES = [
  './',
  'index.html',
  'shopping-list.html',
  'manifest.webmanifest',
  'apple-touch-icon.png',
  'icon-192.png',
  'icon-512.png'
];

self.addEventListener('install', function (e) {
  e.waitUntil(caches.open(CACHE).then(function (c) { return c.addAll(FILES); }).then(function () { return self.skipWaiting(); }));
});

self.addEventListener('activate', function (e) {
  e.waitUntil(caches.keys().then(function (keys) {
    return Promise.all(keys.filter(function (k) { return k !== CACHE; }).map(function (k) { return caches.delete(k); }));
  }).then(function () { return self.clients.claim(); }));
});

self.addEventListener('fetch', function (e) {
  e.respondWith(caches.match(e.request, { ignoreSearch: true }).then(function (hit) { return hit || fetch(e.request); }));
});
