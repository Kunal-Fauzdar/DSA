const d  = {
  "name": "root",
  "type": "folder",
  "children": [
    {
      "name": "level1",
      "type": "folder",
      "children": [
        {
          "name": "file1.txt",
          "type": "file",
          "size": 10
        },
        {
          "name": "level2",
          "type": "folder",
          "children": [
            {
              "name": "file2.txt",
              "type": "file",
              "size": 20
            },
            {
              "name": "level3",
              "type": "folder",
              "children": [
                {
                  "name": "file3.txt",
                  "type": "file",
                  "size": 30
                },
                {
                  "name": "level4",
                  "type": "folder",
                  "children": [
                    {
                      "name": "file4.txt",
                      "type": "file",
                      "size": 40
                    },
                    {
                      "name": "level5",
                      "type": "folder",
                      "children": [
                        {
                          "name": "file5.txt",
                          "type": "file",
                          "size": 50
                        },
                        {
                          "name": "level6",
                          "type": "folder",
                          "children": [
                            {
                              "name": "file6.txt",
                              "type": "file",
                              "size": 60
                            },
                            {
                              "name": "level7",
                              "type": "folder",
                              "children": [
                                {
                                  "name": "file7.txt",
                                  "type": "file",
                                  "size": 70
                                },
                                {
                                  "name": "level8",
                                  "type": "folder",
                                  "children": [
                                    {
                                      "name": "file8.txt",
                                      "type": "file",
                                      "size": 80
                                    }
                                  ]
                                }
                              ]
                            },
                            {
                                "name": "file100.txt",
                                "type": "file",
                                "size": 100
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}

function getSize(node) {
  if (node.type === 'file') {
    return node.size;
  } else if (node.type === 'folder') {
        let totalSize = 0;
        for (let child of node.children) {
        totalSize += getSize(child);
        }
        return totalSize;
    }
}
console.log(getSize(d));

