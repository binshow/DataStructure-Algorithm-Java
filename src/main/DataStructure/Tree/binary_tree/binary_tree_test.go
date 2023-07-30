package binary_tree

import (
	"fmt"
	"strings"
	"testing"
)

func TestName(t *testing.T) {
	s := "My Calendar I"
	s = strings.ReplaceAll(s , " " , "_")
	s = strings.ToLower(s)
	fmt.Println(s)
}
